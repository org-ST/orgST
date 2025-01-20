# github repo: https://github.com/Chureki/CalcTrash

import math
print("CalcTrash V1.0.3 by @Table")
is_running = True
display_ans = True
ans = []
a = 0
b = 0
will_get_b = True
def take_input(special: bool, prompt: str):
    try:
        print(prompt)
    except:
        print("ProgramError: expected string in arg prompt")
        return False
    a = (input(">> "))
    try:
        a = float(a)
        return a
    except:
        if a == "lop" and special:
            try:
                ans[0]
                print("How many operations back?")
                c = input(">> ")
                try:
                    a = ans[len(ans) - int(c)*2]
                except IndexError:
                    print("Error: there was no lop to get")
                    return False
                except:
                    print("Error: invalid value")
                    return False
                return a
            except:
                print("Error: there was no lop to get")
                return False
        elif a == "cancel" and special:
            print("Operation cancelled")
            return (False)
        else:
            print("Error: please input a number")

def check_input(to_check):
    if type(to_check) == int or type(to_check) == float:
        return (True)
    else:
        return (False)

while is_running:
    print("Input operation, else, enter \"help\" for all commands")
    c = input(">> ")
    ops = ["add",1,"add","sub",2,"subtract","mul",2,"multiply","div",2,"divide","exp",2,"exponentiate","sqrt",3,"square root"]
    if ops.count(c) > 0:
        if type(ops[ops.index(c) - 1]) == int:
            c = ops[ops.index(c) - 2]
        elif type(c) == int or type(c) == float:
            print("Error: invalid operation")
            print("")
            continue
        if ops[ops.index(c) + 1] == 1:
            a = take_input(True, f"Please input the first number you want to {c}:")
            will_get_b = True
        elif ops[ops.index(c) + 1] == 2:
            a = take_input(True, f"Please input the first number you want to {ops[ops.index(c) + 2]}:")
            will_get_b = True
        elif ops[ops.index(c) + 1] == 3:
            a = take_input(True, f"Please input the number you want to find the {ops[ops.index(c) + 2]} of:")
            will_get_b = False
        if check_input(a):
            display_ans = True
        else:
            display_ans = False
            continue
        if will_get_b:
            b = take_input(True, "Please input the second:")
            if check_input(b):
                display_ans = True
            else:
                display_ans = False
                continue
    elif ops.count(c) == 0:
        if c == "quit":
            print("Thank you for using CalcTrash.")
            break
        elif c == "help":
            print("""\
add - addition
sub - subtraction
mul - multiplication
div - division
exp - exponentation
sqrt - square root

exit - exit CalcTrash
help - what you're looking at right now
loplist - get the list of last operations
clearlop - clear the loplist

lop - get last operation
cancel - cancel current operation""")
        elif c == "loplist":
            print("last ops:")
            i = 0
            for a in ans:
                if type(a) != str:
                    if a - math.floor(a) != 0:
                        a = float(a)
                    else:
                        a = int(a)
                    print(str(ans[i + 1]) + " " + str(a))
                else:
                    pass
                i += 1
        elif c == "clearlop":
            ans = []
            print("loplist cleared")
        else:
            print("Error: invalid operation")
        display_ans = False
    if display_ans:
        if c == "add":
            ans.append(a + b)
            ans.append("add:")
        elif c == "sub":
            ans.append(a - b)
            ans.append("subtract:")
        elif c == "mul":
            ans.append(a * b)
            ans.append("multiply:")
        elif c == "div":
            ans.append(a / b)
            ans.append("divide:")
        elif c == "exp":
            ans.append(a ** b)
            ans.append("exponent:")
        elif c == "sqrt":
            ans.append(math.sqrt(a))
            ans.append("square root:")
        latest = ans[len(ans) - 2]
        if latest - math.floor(latest) != 0:
            latest = float(latest)
        else:
            latest = int(latest)
        if display_ans:
            print(str(latest) + " is your answer")
    print("")
