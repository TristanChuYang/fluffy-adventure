mytable = setmetatable({key1 = "value1"}, { --为mytable赋值key1
	__index = function(mytable, key) --设置元表，原方法是__index
		if key == "key2" then
			return "metatablevalue"
		else
			return nil
		end
	end
})

print(mytable.key1, mytable.key2) --table中没有key2，就去调用元方法
