Cls
Print ("orgST terminal")
_Title "Local: orgST"
GoTo loops
hello:
Chain "id.bas"
loops:
While 1 + 1 = 2
    Input ">>"; inp$
    If inp$ = "help" Then Print ("help, info, server, exit")
    If inp$ = "exit" Then End
    If inp$ = "info" Then Print ("Edited on 2025-07-28" + "Website: orgst.ca")
    If inp$ = "server" Then Print ("Server has not been created. Please check the website for more details")
    If inp$ = "exit" Then End
    If inp$ = "run" Then GoTo hello
Wend


