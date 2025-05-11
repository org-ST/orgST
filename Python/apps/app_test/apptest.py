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
vers = 1
import subprocess
import os
from time import sleep



while True:
    inp = input(">...")
    if inp == "help":
        print("help, exit, info")
        continue
    if inp == "exit":
        break
    if inp == "info":
        print("apptest.py for orgST" + " | version" + " 1")
        continue
