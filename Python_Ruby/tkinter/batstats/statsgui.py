# statsgui.py

from Tkinter import *
import sys

# create root to contain all
root = Tk()
root.title("Bat Stats GUI")

# create main GUI element
global mainWidget
mainWidget = Frame(root)
Pack.config(mainWidget)

# input labels and fields
atbatlabel = Label(mainWidget, text="ab")
atbatlabel.grid(row=0, column=0)
atbatentry = Entry(mainWidget, width=5)
atbatentry.grid(row=1, column=0)

runslabel = Label(mainWidget, text="r")
runslabel.grid(row=0, column=1)
runsentry = Entry(mainWidget, width=5)
runsentry.grid(row=1, column=1)

hitslabel = Label(mainWidget, text="h")
hitslabel.grid(row=0, column=2)
hitsentry = Entry(mainWidget, width=5)
hitsentry.grid(row=1, column=2)

dbllabel = Label(mainWidget, text="dbl")
dbllabel.grid(row=0, column=3)
dbentry = Entry(mainWidget, width=5)
dbentry.grid(row=1, column=3)

trpllabel = Label(mainWidget, text="trpl")
trpllabel.grid(row=0, column=4)
trplentry = Entry(mainWidget, width=5)
trplentry.grid(row=1, column=4)

hrlabel = Label(mainWidget, text="hr")
hrlabel.grid(row=0, column=5)
hrentry = Entry(mainWidget, width=5)
hrentry.grid(row=1, column=5)

rbilabel = Label(mainWidget, text="rbi")
rbilabel.grid(row=0, column=6)
rbientry = Entry(mainWidget, width=5)
rbientry.grid(row=1, column=6)

bblabel = Label(mainWidget, text="bb")
bblabel.grid(row=0, column=7)
bbentry = Entry(mainWidget, width=5)
bbentry.grid(row=1, column=7)

solabel = Label(mainWidget, text="so")
solabel.grid(row=0, column=8)
soentry = Entry(mainWidget, width=5)
soentry.grid(row=1, column=8)

hbplabel = Label(mainWidget, text="hbp")
hbplabel.grid(row=0, column=9)
hbpentry = Entry(mainWidget, width=5)
hbpentry.grid(row=1, column=9)

sflabel = Label(mainWidget, text="sf")
sflabel.grid(row=0, column=10)
sfentry = Entry(mainWidget, width=5)
sfentry.grid(row=1, column=10)

# calculated labels and fields
avglabel = Label(mainWidget, text="avg")
avglabel.grid(row=3, column=0)
avgdisp = Canvas(mainWidget, height=20, width=35, background="green")
avgdisp.grid(row=4, column=0)

totblabel = Label(mainWidget, text="tb")
totblabel.grid(row=3, column=1)
totbdisp = Canvas(mainWidget, height=20, width=35, background="green")
totbdisp.grid(row=4, column=1)

slglabel = Label(mainWidget, text="slg")
slglabel.grid(row=3, column=2)
slgdisp = Canvas(mainWidget, height=20, width=35, background="green")
slgdisp.grid(row=4, column=2)

obplabel = Label(mainWidget, text="obp")
obplabel.grid(row=3, column=3)
obpdisp = Canvas(mainWidget, height=20, width=35, background="green")
obpdisp.grid(row=4, column=3)

rclabel = Label(mainWidget, text="rc")
rclabel.grid(row=3, column=4)
rcdisp = Canvas(mainWidget, height=20, width=35, background="green")
rcdisp.grid(row=4, column=4)

opslabel = Label(mainWidget, text="ops")
opslabel.grid(row=3, column=5)
opsdisp = Canvas(mainWidget, height=20, width=35, background="green")
opsdisp.grid(row=4, column=5)

talabel = Label(mainWidget, text="ta")
talabel.grid(row=3, column=6)
tadisp = Canvas(mainWidget, height=20, width=35, background="green")
tadisp.grid(row=4, column=6)

bralabel = Label(mainWidget, text="bra")
bralabel.grid(row=3, column=7)
bradisp = Canvas(mainWidget, height=20, width=35, background="green")
bradisp.grid(row=4, column=7)

# the calculation
def calculate():
	# create a batstats object
	import batstats
	statscalc = batstats.new()
	global atbatentry,runsentry,hitsentry,dbentry,trplentry,hrentry,rbientry,bbentry,soentry,hbpentry,sfentry
	batstats.init(statscalc,atbatentry.get(),runsentry.get(),hitsentry.get(),dbentry.get(),trplentry.get(),hrentry.get(),rbientry.get(),bbentry.get(),soentry.get(),hbpentry.get(),sfentry.get()) 
	# update the displays
	global avgdisp, totbdisp, slgdisp, obpdisp, rcdisp, opsdisp, bradisp
	avgdisp.delete(ALL)
	avgdisp.create_text(5, 10, anchor="w", font="Arial 10", justify="center", text=statscalc['avg'])
        totbdisp.delete(ALL)
        totbdisp.create_text(5, 10, anchor="w", font="Arial 10", justify="center", text=statscalc['tb'])
        slgdisp.delete(ALL)
        slgdisp.create_text(5, 10, anchor="w", font="Arial 10", justify="center", text=statscalc['slg'])
        obpdisp.delete(ALL)
        obpdisp.create_text(5, 10, anchor="w", font="Arial 10", justify="center", text=statscalc['obp'])
        rcdisp.delete(ALL)
        rcdisp.create_text(5, 10, anchor="w", font="Arial 10", justify="center", text=statscalc['rc'])
        opsdisp.delete(ALL)
        opsdisp.create_text(5, 10, anchor="w", font="Arial 10", justify="center", text=statscalc['ta'])
        bradisp.delete(ALL)
        bradisp.create_text(5, 10, anchor="w", font="Arial 10", justify="center", text=statscalc['bra'])


# the calc button
calcbutton = Button(mainWidget, text="calculate", command=calculate)
calcbutton.grid(row=5, column=0, columnspan=3, sticky=W)

# run
root.mainloop()

