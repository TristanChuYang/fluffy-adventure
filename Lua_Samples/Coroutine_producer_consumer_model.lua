--productor consumer model

local newProductor

function productor() --�����߲����������ҷ���
	local i = 0
	debug()
	while true do
		i = i + 1
		send(i)
	end
end

function consumer()
	while true do
		local i = receive()
		print(i)
	end
end

function receive()
	local status, value = coroutine.resume(newProductor) --���պ�����coroutine
	return value
end

function send(x)   --���ͷ��� ���ͺ����coroutine
	coroutine.yield(x)
end

newProductor = coroutine.create(productor) --����һ��coroutine������������
consumer()









