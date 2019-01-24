import random

# FUNCTIONS
def list_ends(a):
    return [a[0], a[len(a) - 1]]

def get_integer(txt="Input integer: "):
    return int(input(txt))

def get_string(txt="Input a string: "):
    return str(input(txt))

def gen_fib(length):
    b = []
    if length == 1:
        b = [1]
    elif length >= 2:
        b = [1, 1]
        for i in range(1, length-1):
            b.append(b[i] + b[i - 1])
    return b

def remove_dup_loop(list_a):
    b = []
    [b.append(i) for i in list_a if i not in b]
    return b

def remove_dup_sets(list_a):
    return set(list_a)

def reverse_string(str):
    elements = str.split()
    newStr = ""
    for i in range(len(elements) - 1, -1, -1):
        newStr += elements[i] + " "

    return newStr

def generate_password(length=6):
    chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!£$%^&*()_-+=/.,;'#*|@~:<>?"
    return "".join(random.sample(chars, length))

# MAIN
if __name__=="__main__":
    print(generate_password())