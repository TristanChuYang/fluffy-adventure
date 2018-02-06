function iter(a, i)
	i = i + 1
	local v = a[i]
	if v then
		return i, v
	end
end

function ipairs(a)
 return iter, a, 0
end

array = {"key", "value"}

for key, value in ipairs(array)
	do
	print(key, value)
end

