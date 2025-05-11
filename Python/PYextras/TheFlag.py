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
from colorama import *
valid_hex = '0123456789ABCDEF'.__contains__
def cleanhex(data):
    return ''.join(filter(valid_hex, data.upper()))

def fore_fromhex(text, hexcode):
    """print in a hex defined color"""
    hexint = int(cleanhex(hexcode), 16)
    print("\x1B[38;2;{};{};{}m{}\x1B[0m".format(hexint>>16, hexint>>8&0xFF, hexint&0xFF, text))


fore_fromhex("////////////////////////////////////////", "#E40303")
fore_fromhex("////////////////////////////////////////", "#FF8C00")
fore_fromhex("////////////////////////////////////////", "#FFED00")
fore_fromhex("////////////////////////////////////////", "#008026")
fore_fromhex("////////////////////////////////////////", "#004CFF")
fore_fromhex("////////////////////////////////////////", "#732982")