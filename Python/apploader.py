"""
      orgST - A fun java console with apps
      Copyright (C) 2025  Wdboyes13, MakiDevelops, Table37

      This program is free software: you can redistribute it and/or modify
      it under the terms of the GNU General Public License as published by
      the Free Software Foundation, either version 3 of the License, or any later version.

      This program is distributed in the hope that it will be useful,
      but WITHOUT ANY WARRANTY; without even the implied warranty of
      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
      GNU General Public License for more details.

      You should have received a copy of the GNU General Public License
      along with this program.  If not, see https://www.gnu.org/licenses/.
"""
import json
import os
import subprocess
from time import sleep

with open('apps/apps.json', 'r') as file:
    infoapp = json.load(file)




print("apploader")
a = input(">>")
if a == "apptest":
    print(infoapp["apptest"]["name"])
    print(infoapp["apptest"]["version"])
    print(infoapp["apptest"]["date"])
    sleep(1)
    os.system('cls')
    subprocess.run(["python3", "apps/app_test/apptest.py"])
if a == "salvade":
    print(infoapp["salvade"]["name"])
    print(infoapp["salvade"]["date"])
    sleep(1)
    os.system('cls')
    subprocess.run(["python3", "apps/salvade_demo/main_s.py"])