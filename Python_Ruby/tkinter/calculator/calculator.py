# Will MacLean
# attempt at doing a gui calculator

from Tkinter import *
import sys

# create root to contain all
root = Tk()
root.title("Calculator")

# create main GUI element
global mainWidget
mainWidget = Frame(root)
Pack.config(mainWidget)

# create display
display = Canvas(mainWidget, height=20, width=145, background="green")
display.create_text(5, 10, anchor="w", font="Arial 20", justify="center", text="0")
display.grid(row=0, column=0, columnspan=4, sticky=W)

def up_display(number):
        global display
	display.delete(ALL)
        display.create_text(5, 10, anchor="w", font="Arial 20", justify="center", text=number)
	display.grid(row=0, column=0, columnspan=4, sticky=W)

# string for storing math
math = ""
def more_math(new_math):
        global math
        math = math + new_math
        print math
	up_display(math)

# for doing math
sign = ""
def change_sign(new_sign):
	global sign
	sign = new_sign
math_result = ""
#def do_math(a_sign):
def do_math():
	global math
	global math_result
	global sign
	print sign
	temp = int(math)
	if math_result == "":
		math_result = temp
	else:
		if (sign == "+"):
			math_result = math_result + temp
		elif (sign == "-"):
			math_result = math_result - temp
		elif (sign == "/"):
			math_result = math_result / temp
		elif (sign == "*"):
			math_result = math_result * temp
		else:
			pass # should never get here
	# print result
	global display
	display.delete(ALL)
	math = ""
	up_display(str(math_result))

# print numbers and operators
def print_zero():
	more_math("0")
def print_one():
	more_math("1")
def print_two():
	more_math("2")
def print_three():
	more_math("3")
def print_four():
	more_math("4")
def print_five():
	more_math("5")
def print_six():
	more_math("6")
def print_seven():
	more_math("7")
def print_eight():
	more_math("8")
def print_nine():
	more_math("9")
def print_plus():
	#do_math("+")
	change_sign("+")
	do_math()
def print_minus():
	#do_math("-")
	change_sign("-")
	do_math()
def print_divide():
	#do_math("/")
	change_sign("/")
	do_math()
def print_multiply():
	#do_math("*")
	change_sign("*")
	do_math()
def print_equals():
	global math_result
	do_math()
        display.delete(ALL)
        up_display(str(math_result))
def print_decimal():
	more_math(".")
def clear():
	global math
	global math_result
	global display
	math = ""
	math_result = ""
	display.delete(ALL)

# first button row
button_one = Button(mainWidget, text="1", command=print_one)
button_one.grid(row=1, column=0)

button_two = Button(mainWidget, text="2", command=print_two)
button_two.grid(row=1, column=1)

button_three = Button(mainWidget, text="3", command=print_three)
button_three.grid(row=1, column=2)

button_plus = Button(mainWidget, text="+", command=print_plus)
button_plus.grid(row=1, column=3)

# second button row
button_four = Button(mainWidget, text="4", command=print_four)
button_four.grid(row=2, column=0)

button_five = Button(mainWidget, text="5", command=print_five)
button_five.grid(row=2, column=1)

button_six = Button(mainWidget, text="6", command=print_six)
button_six.grid(row=2, column=2)

button_minus = Button(mainWidget, text="-", command=print_minus)
button_minus.grid(row=2, column=3)

# third button row
button_seven = Button(mainWidget, text="7", command=print_seven)
button_seven.grid(row=3, column=0)

button_eight = Button(mainWidget, text="8", command=print_eight)
button_eight.grid(row=3, column=1)

button_nine = Button(mainWidget, text="9", command=print_nine)
button_nine.grid(row=3, column=2)

button_multiply = Button(mainWidget, text="*", command=print_multiply)
button_multiply.grid(row=3, column=3)

# fourth button row
button_zero = Button(mainWidget, text="0", command=print_zero)
button_zero.grid(row=4, column=0)

button_decimal = Button(mainWidget, text=". ", command=print_decimal)
button_decimal.grid(row=4, column=1)

button_modulus = Button(mainWidget, text="=", command=print_equals)
button_modulus.grid(row=4, column=2)

button_divide = Button(mainWidget, text="/", command=print_divide)
button_divide.grid(row=4, column=3)

# fifth button row
button_quit = Button(mainWidget, text="Quit", command=sys.exit)
button_quit.grid(row=5, column=0, columnspan=2, sticky=W)

button_clear = Button(mainWidget, text="Clear", command=clear)
button_clear.grid(row=5, column=2, columnspan=2, sticky=W)

# run the thing
root.mainloop()

