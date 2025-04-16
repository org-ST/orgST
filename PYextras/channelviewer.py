# Channel Viewer without UI
# Created by progman.task and Table

from time import sleep
import os
from subprocess import run
import webbrowser
from random import choice as rnd_choice
import json

is_looping = True
intro = False

def clear():
    if os.name == 'nt':
        os.system('cls')
    else:
        os.system('clear')
with open('JSONs/channeldata.json', 'r') as file:
    data = json.load(file)
    # print(data)

if intro:
    print("\rGathering Channels", end = '')
    sleep(0.5)
    print("\rGathering Channels.", end = '')
    sleep(0.5)
    print("\rGathering Channels..", end = '')
    sleep(0.5)
    print("\rGathering Channels...")
    sleep(0.5)
    print("\rGathering Sponsor Listings", end = '')
    sleep(0.5)
    print("\rGathering Sponsor Listings.", end = '')
    sleep(0.5)
    print("\rGathering Sponsor Listings..", end = '')
    sleep(0.5)
    print("\rGathering Sponsor Listings...", end = '')
    sleep(0.5)

# code = int(str(rnd_choice(range(10))) + str(rnd_choice(range(10))) + str(rnd_choice(range(10))))
# print("Your secure access code is " + str(code))
# print("")

yes_ins = ['y','yes','Yes','Y','check','Check']
no_ins = ['n','no','No','N']

def do_help():
    print("commands: check, products, people, website, info, comment")

print("Channel Viewer V2.0.1")
print("Would you like to check the current channels?")
a = input(">...")
if yes_ins.count(a):
    while True:
        print("Listings:")
        for n in range(len(data["channels"])):
            print(str(n + 1) + '. ' + data[data["channels"][n]]["name"])
        
        print('(input \"help\" at any time for a list of commands!)')
        b = input(">...")
        try:
            channel = data[data['channels'][int(b) - 1]]
        except:
            if b == 'help':
                do_help()
                sleep(2)
                continue
            elif b == 'exit':
                clear()
                run(['python3', 'main.py'])
            else:
                print('Error: invalid input, please input the number corresponding to the channel')
                sleep(2)
                continue
        
        while True:
            print('Greetings. Welcome to ' + channel['name'] + '.')
            c = input('>...')
            if c == "check":
                files = channel['files']
                if files == False:
                    print("There are no files associated with this channel.")
                    sleep(2)
                    continue
                elif type(files) == list:
                    print("We found some files for you to look at:")
                    for n in range(len(files)):
                        print(str(n + 1) + '. ' + files[n])
                    d = input('>...')
                    try:
                        int(d)
                        print('Opening ' + files[int(d) - 1] + '...')
                        sleep(3)
                        run(['python3', 'PYextras/' + files[int(d) - 1]])
                    except ValueError:
                        if d != 'exit':
                            print('Error: invalid input')
                            sleep(2)
                            print('')
                            continue
                        else:
                            break
                    except:
                        print('Error: file doesn\'t seem to exist...')
                        sleep(2)
                        print('')
                        continue
                    
            elif c == 'web':
                site = channel['website']
                if site == False:
                    print('There is no website associated with this channel.')
                    sleep(2)
                    continue
                elif type(site) == str:
                    print('Opening ' + site + '...')
                    sleep(3)
                    webbrowser.open(site)
                
            elif c == 'products':
                products = channel['products']
                if products == False:
                    print('There are no products associated with this channel')
                    sleep(2)
                    continue
                elif type(products) == list:
                    print('We found some products for you:')
                    for n in range(len(products)):
                        print(str(n + 1) + '. ' + products[n])
                    d = input('>...')
                    try:
                        int(d)
                        print('Opening ' + products[int(d) - 1] + '...')
                        sleep(3)
                        webbrowser.open(products[int(d) - 1] + '...')
                    except ValueError:
                        print('Error: invalid input')
                        sleep(2)
                        print('')
                        continue
                    except:
                        print('Error: product doesn\'t seem to exist...')
                        sleep(2)
                        print('')
                        continue
            
            elif c == 'people':
                print('People: ' + ', '.join(channel['people']))
                sleep(2)
                continue
            
            elif c == 'info':
                print(channel['info'])
                sleep(2)
                continue
            
            elif c == "comment":
                print(channel['comment'])
                sleep(2)
                continue
            
            elif c == "help":
                do_help()
                sleep(2)
                continue
            
            elif c == 'exit':
                break
                
        print('')

        if not(is_looping):
            break

elif no_ins.count(a):
    run(["python3", "main.py"])
elif a == 'DON\'T YOU FRICKIN DARE':
    print('ok man geez')
    run(["python3", "main.py"])
elif a == 'edit':
    run(['python3', 'channelhelper.py'])
if ['help','Help'].count(a):
    do_help()

