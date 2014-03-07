#encoding: Big5

# print out the maze
def printMaze(maze)
	maze.each do |row|
		row.each do |block|
			case block
				when 0 then print " "
				when 1 then print "."
				when 2 then print "#"
			end
		end
		puts
	end
	
	puts "---------------------------------------"
end

class Mouse
	# kick off
    def self.go(maze, start, goal)
        route = []
        visit(maze, start, goal, route)
        route
    end
    
	# visit a point and check reach the goal or not(by recursion)
    def self.visit(maze, pt, goal, route)
        if isVisitable(maze, pt, route)
            route << pt
			# show steps
			maze[pt[:x]][pt[:y]] = 1
			printMaze(maze)
            if not isGoal(route, goal) and 
               not tryOneOut(maze, pt, goal, route)
                route.pop
            end
			# reset the footprint
			maze[pt[:x]][pt[:y]] = 0
        end
        isGoal(route, goal)
    end
    
	# check if a point could be visited or not
    def self.isVisitable(maze, pt, route)
        maze[pt[:x]][pt[:y]] == 0 and not route.include? pt
    end
   
	# check if the goal is reached or not
    def self.isGoal(route, goal)
        route.include? goal
    end
    
	# try 4 directions recursively
    def self.tryOneOut(maze, pt, goal, route)
        visit(maze, {x: pt[:x], y: pt[:y] + 1}, goal, route) or
        visit(maze, {x: pt[:x] + 1, y: pt[:y]}, goal, route) or
        visit(maze, {x: pt[:x], y: pt[:y] - 1}, goal, route) or
        visit(maze, {x: pt[:x] - 1, y: pt[:y]}, goal, route)
    end
end

maze = [
          [2, 2, 2, 2, 2, 2, 2],
          [2, 0, 0, 0, 0, 0, 2],
          [2, 0, 2, 0, 2, 0, 2],
          [2, 0, 0, 2, 0, 2, 2],
          [2, 2, 0, 2, 0, 2, 2],
          [2, 0, 0, 0, 0, 0, 2],
          [2, 2, 2, 2, 2, 2, 2]
       ]
       
goal_pt = {x: 5, y: 5}

Mouse.go(maze, {x: 1, y: 1}, {x: goal_pt[:x], y: goal_pt[:y]}).each do |pt|
    maze[pt[:x]][pt[:y]] = 1
end

if maze[goal_pt[:x]][goal_pt[:y]] == 0
    puts "找不到出口"
end

