mymetatable = {}
mytable = setmetatable({key1 = "value1"}, {__newindex = mymetatable})

print(mytable.key1)

mytable.newkey = "newvalue2" --��__newindex�������Ԫ���ţ�����ֵ
print(mytable.newkey, mymetatable.newkey)

mytable.key1 = "newvalue1"  --����Ԫ�ظ�ֵʱ��������Ԫ����
print(mytable.key1, mymetatable.key1)
