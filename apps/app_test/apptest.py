ver = 1
import subprocess
import os
from time import sleep



while True:
    inp = input(">...")
    if inp == "help":
        print("help, exit, info")
        continue
    if inp == "exit":
        subprocess.run(["python3", "PYextras/channelviewer.py"])
        break
    if inp == "info":
        print("apptest.py for orgST" + " | version" + " 1")
        continue
