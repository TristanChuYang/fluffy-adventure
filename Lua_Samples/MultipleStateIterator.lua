array = {"Lua", "Tutorial"}

function elementIterator (collection)
	local index = 0
	local count = #collection
	-- �հ�����
	return function ()
		index = index + 1
		if index <= count
		then
		--���ص�������ǰԪ��
			return collection[index]
		end
	end
end

for element in elementIterator(array)
	do
		print(element)
end


