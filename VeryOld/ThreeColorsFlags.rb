# encoding: big5
def adjust(flags)
	w = 0
	r = flags.length - 1
	while flags[w] == "B" && w < r
	w += 1
	end
	while flags[r] == "R" && r > 0
	r -= 1
	end
	while w <= r
	case flags[w]
	when "W"
	w += 1
	when "B"
flags.insert(0, flags.slice!(w))
	w += 1
	when "R"
flags << flags.slice!(w)
	r -= 1
	end
	end

	flags
	end

	print "Enter flags colors(e.g.RWBBWRWR):"
	flags = gets.chomp!
flags = adjust(flags)
	print "After process:#{flags} \n"
