import tkinter.filedialog
from tkinter import *
from tkinter import ttk
from tkVideoPlayer import TkinterVideo

def videoplayer():




def main() :
    root = Tk()
    frm = ttk.Frame(root, padding=10)
    frm.grid()
    ttk.Label(frm, text="orgST").grid(column=0, row=0)
    ttk.Button(frm, text="VideoPlayer", command=videoplayer).grid(column=1, row=0)
    root.mainloop()

main()