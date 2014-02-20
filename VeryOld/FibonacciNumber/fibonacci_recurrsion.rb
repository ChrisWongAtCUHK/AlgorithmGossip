# encoding: utf-8
def fib(n)
	if n == 0 or n == 1
		return n
	end

	a = 0
	b = 1

	for i in 2..n 
		temp = b
		b = a + b
		a = temp
	end
	return b
end

print "輸入個數："
length = gets.to_i
0.upto(length - 1) do |i|
    print fib(i).to_s + ' '
end
