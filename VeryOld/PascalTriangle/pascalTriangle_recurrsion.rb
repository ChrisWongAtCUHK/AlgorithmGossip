# encoding: utf-8

# http://openhome.cc/Gossip/AlgorithmGossip/PascalTriangle.htm#Ruby
def combi(r, n)
    return 1 if n == 0; combi(r, n - 1) * (r - n + 1) / n
end

width = 3				# width of each number
print "輸入個數："		# seem to at most 20 would be displayed visibly
height = gets.to_i
0.upto(height - 1) do |r|
    printf "%" + ((height - r) * width).to_s + "s", ""
    0.upto(r) do |n|
    	printf "%" + (width * 2).to_s + "d", combi(r, n)
    end
    puts
end

