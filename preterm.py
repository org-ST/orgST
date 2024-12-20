# alternate terminal green
import subprocess
import time
std1=False
a=input(">...")
if a=="COMP":
    if std1==True:
        subprocess.run(["python3", "org_terminal.py"])
    else:
        print("run DOWNLOAD")
if a=="DOWNLOAD":
    print("Downloading TERMINAL")
    time.sleep(3)
    print("---------------------100%")
    print("run COMP")
    std1=True
    b=input(">...")
    if b=="COMP":
        if std1==True:
            subprocess.run(["python3", "org_terminal.py"])
    else:
        print("run DOWNLOAD")
