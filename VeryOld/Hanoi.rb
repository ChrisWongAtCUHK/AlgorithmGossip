# encoding: utf-8
def hanoi(n, a, b, c)
    if n == 1
        [{from: a, to: c}]
    else
        hanoi(n - 1, a, c, b) + hanoi(1, a, b, c) + hanoi(n - 1, b, a, c)
    end
end

print "請輸入整數："
hanoi(gets.to_i, "A", "B", "C").each do |move|
    print "盤子從 #{move[:from]} 移動至 #{move[:to]}\n"
end