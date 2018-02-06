--productor consumer model

local newProductor

function productor() --生产者不断生产并且发送
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
	local status, value = coroutine.resume(newProductor) --接收后重启coroutine
	return value
end

function send(x)   --发送方法 发送后挂起coroutine
	coroutine.yield(x)
end

newProductor = coroutine.create(productor) --创建一个coroutine来创建生产者
consumer()









