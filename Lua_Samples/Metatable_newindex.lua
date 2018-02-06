mymetatable = {}
mytable = setmetatable({key1 = "value1"}, {__newindex = mymetatable})

print(mytable.key1)

mytable.newkey = "newvalue2" --有__newindex，会调用元发放，不赋值
print(mytable.newkey, mymetatable.newkey)

mytable.key1 = "newvalue1"  --对老元素赋值时，不调用元方法
print(mytable.key1, mymetatable.key1)
