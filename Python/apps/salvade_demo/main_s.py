from colorama import Fore, Style, Back
import os 
import time
import random
import sys
from classes_s import player, enemy, battle

def make_bar(val, max_val, length, color):
    colorkey = {
        'red': Fore.RED,
        'blue': Fore.BLUE,
        'green': Fore.GREEN,
        'grey': Style.DIM + Fore.WHITE,
        'cyan': Fore.CYAN,
        'yellow': Fore.YELLOW,
        'white': Fore.WHITE,
    }
    string = ['[']
    for i in range(length):
        if val > max_val*((1/length)*(i)):
            string.append(colorkey[color] + '-' + Style.RESET_ALL)
        else:
            if color == 'grey':
                string.append(' ')
            else:
                string.append(f'{colorkey[color]}{Style.DIM}-{Style.RESET_ALL}')
    string.append(']')
    return ''.join(string)

print(Fore.GREEN + Style.BRIGHT + 'SALVADE V0.5' + Style.RESET_ALL)
print('Press enter to play')
input()

os.system('cls')

print('What is your name?')
player = player(input('>> '))

player.mana[0], player.mana[1] = 15, 15

os.system('cls')
time.sleep(0.5)


if player.name.lower() == 'frisk':
    print('The true name.')
else:
    print('Hello, ' + player.name)
time.sleep(1)
os.system('cls')
battle = battle()
enemy = enemy('Dummy', [350, 80, 10, 50], ['attack'], ['random', '...',"it's just a dummy","what are you doing?", 'the storm approaches', '*does a little shimmy*', 'DANCE BATTLE!!!', '***dummytext***'], 60)
if player.name.lower() == 't+':
    print('T+ VS SHARK')
else:
    print('Yes, indeed, there is a ' + enemy.name)
turner = player
not_turner = enemy
turns = 0
while True:
    while True:
        # in battle
        if enemy.hp[1] == 0:
            print('You killed ' + enemy.name + '!')
            sys.exit(0)
            os.system('clear')
            break
        elif player.hp[1] == 0:
            print('Aw shucks, you died :(')
            time.sleep(3)
            print('Do better next time, ok?')
            sys.exit(0)
        
        print(f'{player.name}: {make_bar(player.hp[1], player.hp[0], 6, 'red')} {player.hp[1]}/{player.hp[0]} {make_bar(player.shield[1], player.shield[0], 6, 'white')} {player.shield[1]}/{player.shield[0]} {make_bar(player.mana[1], player.mana[0], 6, 'cyan')} {player.mana[1]}/{player.mana[0]} | statuses: {Fore.RED}{player.statuses[0]} {Fore.GREEN}{player.statuses[1]} {Fore.YELLOW}{player.statuses[2]} {Fore.WHITE}{Style.DIM}{player.statuses[3]} {Fore.WHITE}{Style.NORMAL}{player.statuses[4]}{Style.RESET_ALL}')
        print(f'{enemy.name}: {make_bar(enemy.hp[1], enemy.hp[0], 6, 'red')} {enemy.hp[1]}/{enemy.hp[0]} {make_bar(enemy.shield[1], enemy.shield[0], 6, 'white')} {enemy.shield[1]}/{enemy.shield[0]} {make_bar(enemy.mana[1], enemy.mana[0], 6, 'cyan')} {enemy.mana[1]}/{enemy.mana[0]} | statuses: {Fore.RED}{enemy.statuses[0]} {Fore.GREEN}{enemy.statuses[1]} {Fore.YELLOW}{enemy.statuses[2]} {Fore.WHITE}{Style.DIM}{enemy.statuses[3]} {Fore.WHITE}{Style.NORMAL}{enemy.statuses[4]}{Style.RESET_ALL}')
        
        if enemy.broken >= 5 and enemy.hp[1] <= enemy.hp[0]/10 and turner == player:
            print('You can now ' + Fore.GREEN + Style.BRIGHT + 'SALVAGE' + Style.RESET_ALL)
        
        if enemy.dialogue[0] == 'random':
            dialogue_list = []
            for i in range(len(enemy.dialogue)):
                if i != 0:
                    dialogue_list.append(enemy.dialogue[i])
        print(enemy.name + ': ' + random.choice(dialogue_list))
        
        if turner == player:
            a = input('>> ')
            check = battle.check(a, False, player, enemy)
            if check == True:
                print(turner.name + ' used ' + a + '!')
                time.sleep(2)
                battle.check(a, True, player, enemy)
            elif check == 'broke':
                print('come back when youre... a little richer')
                time.sleep(2)
                os.system('cls')
                continue
            elif a in ['Skills', 'skills']:
                for i in range(len(battle.skills.keys())):
                    print(list(battle.skills.keys())[i])
                input()
                os.system('cls')
                continue
            elif a.lower() == 'salvage':
                if enemy.broken >= 5 and enemy.hp[1] <= enemy.hp[0]/10:
                    print('You successfully salvaged ' + enemy.name + ' for 100 coins!')
                    sys.exit(0)
                else:
                    print('requirements unsatisfied.')
                    print(f'enemy shield broken: {enemy.broken}/5, enemy hp needs to be under 10%')
                    time.sleep(3)
                    os.system('cls')
                    continue
            else:
                print('That isn\'t a valid action, for more info, please use the skills command')
                time.sleep(2)
                os.system('cls')
                continue
        else:
            if enemy.mana[1] < 2:
                print(enemy.name + ' charged!')
                time.sleep(2)
                battle.check('charge', True, enemy, player)
            elif not(enemy.mana[1] <= enemy.mana[0]/2):
                print(enemy.name + ' attacked!')
                time.sleep(2)
                battle.check('attack', True, enemy, player)
            elif random.random()*100 <= enemy.aggro:
                print(enemy.name + ' attacked!')
                time.sleep(2)
                battle.check('attack', True, enemy, player)
            else:
                print(enemy.name + ' charged!')
                time.sleep(2)
                battle.check('charge', True, enemy, player)
        os.system('cls')
        
        if turner == player:
            turner = enemy
            not_turner = player
        else:
            turner = player
            not_turner = enemy
        
        for i in range(len(turner.statuses)):
            if turner.statuses[i] > 0:
                turner.statuses[i] -= 1
                if i <= 1:
                    battle.damage(not_turner.attack*(0.50*(int((i == 0 and turner.shield == 0) or (i == 1 and turner.shield != 0)) + 1)), not_turner, turner)
                elif i == 2:
                    if turner == player:
                        turner = enemy
                    else:
                        turner = player
                elif i == 4:
                    pass
                
            else:
                if i == 4:
                    turner.crit /= 2
        
        if turner.statuses[3] == -1:
            battle.increase(turner, 'shield', round(turner.shield[0]/3))
            turner.statuses[3] = 0
            
        if turner.statuses[3] <= 0:
            turner.statuses[3] = -1
        turns += 1