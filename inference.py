import re 
def searSepc(str):
	word = u'then' 
	a = [m.start() for m in re.finditer(word, str)] 
	return a[0]

def match(fact):
	for line in open("knowledge.txt"):  
	    locate=searSepc(line)
	    itcpt=line[3:locate-1]
	    if itcpt==fact:
	     	return line[locate+5:].strip()
	return False 
def cheStop(res):#判断是否终止事实
	if res=='a':
		return True
	if res=='b':
		return True
	return False

old='3,4'
while True:
	res=match(old)
	if res==False:
		print("Wrong input!")
		exit()
	old=res
	print("res:    ",end='')
	print(res)
	if cheStop(res):
		break
	
