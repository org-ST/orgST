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