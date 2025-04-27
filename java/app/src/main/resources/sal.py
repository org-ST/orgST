from colorama import Fore, Style, Back
import os 
import time
import random
import sys
import platform
def clear():
    os_name = platform.system()
    if os_name == "Windows":
        os.system('cls')
    else:
        os.system('clear')
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

# the classes
import random
import time

class enemy:
    
    def __init__(self, name, stats, skills, dialogue, aggro):
        self.name = name # name of enemy
        self.hp = [stats[0], stats[0]] # [hp, shield, mana, atk]
        self.shield = [stats[1], stats[1]] # format: [max, current]
        self.mana = [stats[2], stats[2]]
        self.attack = stats[3]
        self.crit = 25
        self.skills = skills # [heal, shield anni]
        self.dialogue = dialogue # [type('sequence', 'random'), 'IT WAS A SPECIAL DAY', 'YOU WANTED TO GET BACK FAST']
        self.aggro = aggro # aggro%
        self.statuses = [0,0,0,0,0] # status effects active, [burn, acid, stun, break]
        self.broken = 0 # times shield has been broken
    
class player:
    def __init__(self, name):
        self.name = name
        self.hp = [100, 100]
        self.shield = [15,15]
        self.mana = [10,10]
        self.attack = 10
        self.crit = 25
        self.statuses = [0,0,0,0,0] # [burn, acid, stun, break, crit more]
        self.broken = 0

class battle:
    def __init__(self):
        self.skills = {
            'attack': [self.attack, 2],
            'hit': [self.hit, 2],
            'whack': [self.whack, 10],
            'charge': [self.charge, 0],
            'heal': [self.heal, 5],
            'stun': [self.stun, 5],
            'triple hit': [self.triple_hit, 5],
            'defend': [self.defend, 2],
            'pierce': [self.pierce, 5],
            'focus': [self.focus, 2],
            'burn': [self.burn, 5],
            'acidify': [self.acidify, 5],
            'the ultimate': [self.ultimate, 15],
            'exit' : [self.exit, 0]
        }
    def exit(self, attacker, victim):
        os.system('java -jar *1.8.jar')
    def damage(self, dmg, attacker, victim):
        shield = victim.shield[1]
        hp = victim.hp[1]
        if random.random()*100 <= attacker.crit:
            dmg = dmg*2
            print('Critical Hit!')
        if shield > 0 and victim.statuses[3] < 1:
            shield -= dmg
            victim.statuses[3] = 0
            if shield <= 0:
                shield = 0 
                victim.statuses[3] = 1
                victim.broken += 1
        else:
            hp -= dmg
            if hp < 0:
                hp = 0
        
        print(dmg)
        time.sleep(0.5)
        victim.shield[1] = shield
        victim.hp[1] = hp
    
    def increase(self, who, param, amount):
        hp = who.hp
        shield = who.shield
        mana = who.mana
        if param in ['hp', 'health']:
            hp[1] += amount
            if hp[1] > hp[0]:
                hp[1] = hp[0]
        elif param in ['shield', 'sh']:
            shield[1] += amount
            if shield[1] > shield[0]:
                shield[1] = shield[0]
        elif param in ['mana']:
            mana[1] += amount
            if mana[1] > mana[0]:
                mana[1] = mana[0]
        else:
            print(f'Error, {param} is not a stat')
        
        who.hp = hp
        who.shield = shield
        who.mana = mana
    
    def again(self, attacker, victim):
        if victim.statuses[2] < 1:
            victim.statuses[2] = 1
        else:
            victim.statuses[2] += 1
    
    def check(self, inp: str, will_run: bool, player, enemy):
        if inp.lower() in self.skills.keys():
            if player.mana[1] >= self.skills[inp.lower()][1]:
                if will_run:
                    self.skills[inp.lower()][0](player, enemy)
                    player.mana[1] -= self.skills[inp.lower()][1]
                else:
                    return True
            else:
                return 'broke'
        else:
            return 'invalid'
    
    def attack(self, attacker, victim):
        self.damage(attacker.attack, attacker, victim)
    
    def defend(self, attacker, victim):
        self.increase(attacker, 'shield', 1)
        if victim.statuses[2] < 1:
            victim.statuses[2] = 1
        else:
            victim.statuses[2] += 1
    
    def stun(self, attacker, victim):
        self.damage(attacker.attack*1.5, attacker, victim)
        victim.statuses[2] = 1
    
    def charge(self, who, enemy):
        who.mana[1] = who.mana[0]
    
    def triple_hit(self, attacker, victim):
        self.damage(attacker.attack*0.5,attacker,victim)
        time.sleep(0.5)
        self.damage(attacker.attack*0.5,attacker,victim)
        time.sleep(0.5)
        self.damage(attacker.attack,attacker,victim)
    
    def pierce(self, attacker, victim):
        victim.statuses[3] = 2
        self.damage(attacker.attack*1.5, attacker, victim)
    
    def focus(self, attacker, victim):
        attacker.crit *= 2
        attacker.statuses[4] = 3
        if victim.statuses[2] < 1:
            victim.statuses[2] = 1
        else:
            victim.statuses[2] += 1
    
    def burn(self, attacker, victim):
        self.damage(attacker.attack*1.5, attacker, victim)
        victim.statuses[0] += 2
    
    def acidify(self, attacker, victim):
        self.damage(attacker.attack*1.5, attacker, victim)
        victim.statuses[1] += 2
    
    def ultimate(self, attacker, victim):
        self.damage(attacker.attack*2.5, attacker, victim)
        victim.statuses[0] += 3
        victim.statuses[1] += 3
        victim.statuses[2] += 3
        victim.statuses[3] += 3
        attacker.statuses[4] += 3
    
    def heal(self, attacker, victim):
        self.increase(attacker, 'hp', attacker.hp[0]*25)
    
    def hit(self, attacker, victim):
        self.damage(attacker.attack*0.5, attacker, victim)
        self.again(attacker, victim)
    
    def whack(self, attacker, victim):
        self.damage(attacker.attack*2.5, attacker, victim)
        self.again(attacker, victim)


print(Fore.GREEN + Style.BRIGHT + 'SALVADE V0.5' + Style.RESET_ALL)
print('Press enter to play')
input()

clear()

print('What is your name?')
player = player(input('>> '))

player.mana[0], player.mana[1] = 15, 15

clear()
time.sleep(0.5)


if player.name.lower() == 'frisk':
    print('The true name.')
else:
    print('Hello, ' + player.name)
time.sleep(1)
clear()
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
                clear()
                continue
            elif a in ['Skills', 'skills']:
                for i in range(len(battle.skills.keys())):
                    print(list(battle.skills.keys())[i])
                input()
                clear()
                continue
            elif a.lower() == 'salvage':
                if enemy.broken >= 5 and enemy.hp[1] <= enemy.hp[0]/10:
                    print('You successfully salvaged ' + enemy.name + ' for 100 coins!')
                    sys.exit(0)
                else:
                    print('requirements unsatisfied.')
                    print(f'enemy shield broken: {enemy.broken}/5, enemy hp needs to be under 10%')
                    time.sleep(3)
                    clear()
                    continue
            else:
                print('That isn\'t a valid action, for more info, please use the skills command')
                time.sleep(2)
                clear()
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
        clear()
        
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