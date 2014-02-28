# encoding: utf-8

def combi(r, n)
    p = 1
	for i in 1..n
		p = p * (r - i + 1)/i
	end
	return p
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

