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
            'the ultimate': [self.ultimate, 15]
        }
    
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