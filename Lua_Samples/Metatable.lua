mytable = setmetatable({key1 = "value1"}, { --Ϊmytable��ֵkey1
	__index = function(mytable, key) --����Ԫ��ԭ������__index
		if key == "key2" then
			return "metatablevalue"
		else
			return nil
		end
	end
})

print(mytable.key1, mytable.key2) --table��û��key2����ȥ����Ԫ����
