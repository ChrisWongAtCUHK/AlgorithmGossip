# encoding: utf-8
def fib(n)
	if n <= 1
		return n
	end

	if n == 2
		return 1
	else
		i = n/2
		f1 = fib(i + 1)
		f2 = fib(i)
		if (n % 2) == 0
			return (f2 * (2 * f1 - f2))
		else
			return ((f1 * f1) + (f2 * f2))
		end
	end
	return n
end

print "輸入個數："
length = gets.to_i
0.upto(length - 1) do |i|
    print fib(i).to_s + ' '
end
