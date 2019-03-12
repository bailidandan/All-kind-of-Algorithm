import re 
def searSepc(str,word):#在str中找到指定单词的位置 
	a = [m.start() for m in re.finditer(word, str)] 
	return a[0]
def match():
	for line in open("knowledge1.txt"):  
	    locate=searSepc(line,'->')
	    front=line[:locate-1]
	    rear=line[locate+3:]
	    print(front)
	    print(rear)
	    print("￢"+front+"∪"+rear)
match()