# encoding: utf-8
fibonacci = -> {
    fib = [0, 1]
    -> n { 
        if n >= fib.size
            fib.size.upto(n) do |i|
                fib << fib[i - 1] + fib[i - 2]
            end
        end
        fib[n]
    }
}.call

print "輸入個數："
length = gets.to_i
0.upto(length - 1) do |i|
    print fibonacci.call(i).to_s + ' '
end