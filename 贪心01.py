class Good:

    def __init__(self, weight, value, status):
        self.weight = weight
        self.value = value
        self.status = status   # 0未选中，1已选中


#@param goods 物品的集合
#@param total 背包的空闲重量
def greed(goods, total):
    result = []

    while True:
        s=strategy(goods,total)
        if s == -1:
            break;#整个包已经满了
        result.append(goods[s].weight)
        total = total - goods[s].weight
        goods[s].status = 1
    return result

#策略
def strategy(goods,total):
    index = -1
    minWeight = goods[0].weight
    for i in range(0, len(goods)):
        currentGood = goods[i]#从goods中取出一个，显然goods并没有排序

        if currentGood.status == 0 and currentGood.weight <= total and currentGood.weight <= minWeight :#选择出来其中的最小重量
            index = i
            minWeight = goods[index].weight

    return index
gs=[]
gs0 = Good(1,3,0)
gs1 = Good(2,3,0)
gs2 = Good(1,4,0)
gs.append(gs0)
gs.append(gs1)
gs.append(gs2)
total=4
print("打印结果：")
print(greed(gs,total))