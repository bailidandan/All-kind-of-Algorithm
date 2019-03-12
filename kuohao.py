class SStack():
    def __init__(self):
        self.__elem = []
    def is_empty(self):
        return self.__elem == []
    def top(self):
        return self.__elem[-1]
    def push(self,elem):
        self.__elem.append(elem)
    def pop(self):
        return self.__elem.pop()

def kuohao(text):
    kinds = "()[]{}"#用来定义出现的括号，因为待匹配的字符中含有其他的字符，我们值检查括号是否匹配，而且是只有出现括号后再进行匹配
    zuo = "([{" #定义左括号，如果是左括号就入栈
    dict0 = {")":"(","]":"[","}":"{"}#匹配字典，这个字典定义了匹配规则，如果字典的键值对匹配就可以认定括号是匹配的

    def pipei(text):     #将等待匹配的文本输入，这个函数的目标是从文本中过滤出括号
        i,text_len = 0,len(text) #扫描指针用来记录匹配位置
        while True:
            while  i< text_len and text[i] not in kinds: #用来寻找到括号
                i += 1
            if i >= text_len: #如果字符串中没有包含括号则结束
                return
            yield text[i],i  #返回括号字符和字符对应的下标
            i += 1


    st = SStack()
    for text0,i in pipei(text):#获取得到的符号进行匹配,因为pipei（）是一个含有yield函数，所以是一个生成器，调用它会产生一个可迭代的对象
        if text0 in zuo: #如果是左括号就让它入栈
            #print(text0)
            st.push(text0)
        elif st.pop() != dict0[text0]:#如果是右括号，就弹出栈顶元素进行匹配检查
            print("本次不匹配")
            return False #遇到不匹配的，就直接退出函数，结束匹配
    print("所有的括号都已经匹配完毕，匹配成功！") #如果函数还能够执行到这里说明所有的括号都是匹配的
    return True
kuohao("({{[]}})")
# kuohao("[{]}")