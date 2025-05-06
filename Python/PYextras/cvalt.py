import json
import subprocess
import webbrowser
from time import sleep

# Load the channel data from the JSON file
with open('JSONs/channeldata.json', 'r') as file:
    data = json.load(file)

# Function to get channel info from the channels list
def getchan(inp):
    inn = inp.split(" ")[1]
    if inn.isdigit() and int(inn) <= len(data["channels"]) and int(inn) > 0:
        channel_name = data["channels"][int(inn) - 1]  # Get the channel name
        channel = data[channel_name]  # Get the full channel details using the channel name
        return channel
    return None

# Print the available channels
print("Listings:")
for n in range(len(data["channels"])):
    channel_name = data["channels"][n]  # Channel name from the "channels" array
    print(f"{n + 1}. {data[channel_name]['name']}")  # Display the name of the channel

while 0 == 0:
    # get user input
    inp = input(">...")
    if inp == "help":
        print("Commands: run, comment, products, web, people, info")
        continue
    elif inp == "exit":
        break
    channel = getchan(inp)
    if inp.startswith("run "):
        # Get the corresponding channel and its file path
        if channel:
            file_path = channel["fp"]  # Fetch the file path from the 'fp' key
            
            # Run the Python file located at the file path
            subprocess.run(["python3", file_path])

    elif inp.startswith("comment "):
        if channel:
            print(channel['comment'])
    elif inp.startswith("products "):
        products = channel['products']
        if products == False:
            print('There are no products associated with this channel')
            continue
        elif type(products) == list:
            print('We found some products for you:')
            for n in range(len(products)):
                print(str(n + 1) + '. ' + products[n])
            d = input('>...')
            try:
                int(d)
                print('Opening ' + products[int(d) - 1] + '...')
                webbrowser.open(products[int(d) - 1] + '...')
            except ValueError:
                print('Error: invalid input')
                print('')
                continue
            except:
                print('Error: product doesn\'t seem to exist...')
                print('')
    elif inp.startswith("web "):
        site = channel['website']
        if site == False:
            print('There is no website associated with this channel.')
            continue
        elif type(site) == str:
            print('Opening ' + site + '...')
            webbrowser.open(site)
    elif inp.startswith("people "):
        print('People: ' + ', '.join(channel['people']))
        continue
                
    elif inp.startswith("info "):
        print(channel['info'])
        continue