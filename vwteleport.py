ver = 23.652

print("vimeworld teleport ver: " + str(ver))

login = input("login: ")
password = input("password: ")

def downloadDll():
	dll = requests.get()
	with open("vimeworldteleport.dll", "wb") as file:
		file.write(dll.content)

import time
import random
import requests
print("trying to authenticate...")
time.sleep(random.randint(2, 6))
if login == "tester":
	if password == "tester":
		print("authenticated! welcome to vimeworldteleport, " + login)
	else:
		print("incorrect login or password")
		exit()
else:
	print("incorrect login or password")
	exit()

print("checking for exists main .dll library")

if os.path.exists("vimeworldteleport.dll"):
	print("dll is exists!")
else:
	print("dll is not exists! downloading .dll file")