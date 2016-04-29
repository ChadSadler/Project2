#!/usr/bin/ruby -w

deck = Array[];
hand = Array[];
hit = 1;
used = 0;
total = 0;

for suit in 0..3
	for value in 1..13
		deck.push(value);
	end
end

51.downto(0).each { |i|
	random = rand(i+1);
	temp = deck.at(i);
	deck[i] = deck[random];
	deck[random] = temp;
}

=begin
for i in 0..deck.length-1
	print "#{deck[i]} ";
end
=end

print "Welcome to BlackJack\n";

while hit == 1 do
	case deck[used]
		when 1
			hand.push("A")
			
			if total <= 10
				total += 11
			else
				total += 1
			end
		when 11
			hand.push("J")
			total += 10
		when 12
			hand.push("Q")
			total += 10
		when 13
			hand.push("K")
			total += 10
		else
			hand.push(deck[used].to_s)
			total += deck[used]
	end

	used += 1;

	if used >= 2
		print "Your cards:"
		
		for i in 0..used-1
			print " #{hand[i]}"
		end
		print " (Total: #{total})"

		if total == 21
			print "\nBlackjack!\n"
			break
		elsif total > 21
			print "\nBust!\n"
			break
		end
		
		print "\n\nPlease enter an option: 1 - Hit 2 - Stay\n"
		hit = gets.to_i
		print "\n"
	end
end