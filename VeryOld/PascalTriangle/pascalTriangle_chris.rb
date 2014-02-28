# encoding: utf-8

# No need to use recursion or for loop^^
def combi(r, n, p)
	if n != 0 
		p = p * (r - n + 1)/n
	end
	return p
end

p = 1
width = 3				# width of each number
print "輸入個數："		# seem to at most 20 would be displayed visibly
height = gets.to_i
0.upto(height - 1) do |r|
    printf "%" + ((height - r) * width).to_s + "s", ""
    0.upto(r) do |n|
		p = combi(r, n, p)
    	printf "%" + (width * 2).to_s + "d", p
    end
    puts
end

