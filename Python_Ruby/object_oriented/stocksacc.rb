# stocksacc.rb
#
# Will MacLean
# CSPP 51060

# This version requires direct access to instance variables,
# which is impossible in Ruby. 

require 'csv'
require 'portreader'
require 'tableformatter'

# storage for min and max info
min = 'none'
minDate = 'none'
minDayList = {}
max = 'none'
maxDate = 'none'
maxDayList = {}

# a function to perform a deep copy
def deep_clone(object)
        Marshal::load(Marshal.dump(object))
end

# creating a Stock class
class Stock
        attr_reader :name, :shares, :price, :value, :change
        attr_writer :name, :shares, :price, :value, :change
        def initialize(name, shares, price)
                @name = name
                @shares = Integer(shares)
                @price = Float(price)
		@value = Float(price) * Float(shares)
		@change = 0.0
        end
	# a function to print a stock
	def printStock
		printf "\n%10s %10d %10.2f, %+10.2f", name, Integer(shares), Float(price), Float(change)
	end
        # a function to perform a deep copy
        def deep_clone
                Marshal::load(Marshal.dump(self))
        end
end

#test = Stock.new("ORCL", 100, 20.00)
#testCopy = test.deep_clone()
#test2 = deep_clone(test)

# for reading CSV files
def readToList( filename )
	reader = CSV::parse(File.open(filename) {|f| f.read} )
	return reader
end

# read CSV files
#portfolio = readToList( "dowportfolio.csv" )
stocks = readToList( "dowstocks.csv" )

read_port = My_Reader.new("dowportfolio.rec")
portfolio = read_port.read

# function to create stock keys
def getStockKey ( arr )
	return arr[0] + arr[2]
end

# function to get dateTimes
def getDateTime ( arr )
	return arr[2] + " " + arr[3]
end

# creating a bunch of stocks
stockDict = {}
stockKeys = {}
stockNames = {}
for val in portfolio
	aStock = Stock.new(val[0], val[1], val[2])
	aStock.printStock
	aStockKey = getStockKey(val)
	stockDict[aStockKey] = aStock
	stockKeys[aStockKey] = aStockKey
	if (stockNames.has_key?(val[0]) == false)
		stockNames[val[0]] = val[0]
	end
end

print stockDict

# calc the day
def calcDay(stockKeys, stockDict)
	tot = 0.0
	for key in stockKeys
		tot = tot + Float(stockDict[key[1]].value)
	end
	return tot
end

# get start vals
initVal = calcDay(stockKeys, stockDict)
min = initVal
max = initVal

# update stockDict
def updateStockDict(stockKeys, stockDict, name, newPrice)
	for keyBlech in stockKeys
		key = keyBlech[1]
		testName = stockDict[key].name
		if (testName == name)
			temp = Float(stockDict[key].price)
			newVal = Float(stockDict[key].shares) * Float(newPrice)
			stockDict[key].change = Float(newPrice) - Float(stockDict[key].price)
			stockDict[key].value = newVal
			stockDict[key].price = newPrice
		end
	end
end

# calcing the days
currentDateTime = getDateTime(stocks[0])
for value in stocks:
	name = value[0]
	if(stockNames.has_key?(name) == true)
		price = value[1]
		dateTime = getDateTime(value)
		if (currentDateTime == dateTime)
			updateStockDict(stockKeys, stockDict, name, price)
		else
			currentDate = dateTime
			total = calcDay(stockKeys, stockDict)
			if (min > total)
				min = total
				minDate = dateTime
				minDayList = deep_clone(stockDict) 
			end
			if (max < total)
				max = total
				maxDate = dateTime
				maxDayList = deep_clone(stockDict)
			end
		end
	end
end

# function to print finals
def printFinals(minOrMax, tot, date, dayDict, stockKeys)
	printf "\n==============="
	printf "\n%s Values: $ %10.2f at %25s", minOrMax, tot, date 
	printf "\n==============="
	printf "\n%10s %10s %10s %10s", 'Name', 'Shares', 'Price', 'Change'
	printf "\n" + "---------- " * 4
	for keyBlech in stockKeys
		key = keyBlech[1]
		dayDict[key].printStock()
	end
end

print minDayList

# print the finals
printFinals("Minimum", min, minDate, minDayList, stockKeys)
printFinals("Maximum", max, maxDate, maxDayList, stockKeys)

# using TableFormatter classes
heads = ["Name", "Shares", "Price", "Change"]
stockForTable = []
x=0
for keyBlech in stockKeys
	key = keyBlech[1]
	this = stockDict[key]
	newStock = [this.name, this.shares, this.price, this.change]
	stockForTable[x]=newStock
	x = x+1
end

# text table
texttable = TableFormatter.new(heads, stockForTable)
texttable.buildtable

# html table
htmltable = HtmlTableFormatter.new(heads, stockForTable)
htmltable.buildtable

# csv table
csvtable = CsvTableFormatter.new(heads, stockForTable)
csvtable.buildtable




# this is just to move the prompt to the next line when done
printf "\n"
