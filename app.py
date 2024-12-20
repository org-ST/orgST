import tkinter.filedialog
from tkinter import *
from tkinter import ttk
from tkintervideo import player
from tkintervideo.tools import Controls
import sv_ttk
import time
def videoplayer():
    print("e")



def main() :
    root = Tk()
    frm = ttk.Frame(root, padding=10)
    frm.grid()
    ttk.Label(frm, text="orgST").grid(column=0, row=0)
    ttk.Button(frm, text="VideoPlayer", command=videoplayer).grid(column=1, row=0)
    root.mainloop()

main()