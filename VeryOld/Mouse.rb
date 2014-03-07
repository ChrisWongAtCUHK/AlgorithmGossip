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
    def self.go(maze, start, goal)
        route = []
        visit(maze, start, goal, route)
        route
    end
    
    def self.visit(maze, pt, goal, route)
        if isVisitable(maze, pt, route)
            route << pt
			
            if not isGoal(route, goal) and 
               not tryOneOut(maze, pt, goal, route)
                route.pop
            end
        end
        isGoal(route, goal)
    end
    
    def self.isVisitable(maze, pt, route)
        maze[pt[:x]][pt[:y]] == 0 and not route.include? pt
    end
   
    def self.isGoal(route, goal)
        route.include? goal
    end
    
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
       
end_pt = {x: 5, y: 5}

Mouse.go(maze, {x: 1, y: 1}, {x: end_pt[:x], y: end_pt[:y]}).each do |pt|
    maze[pt[:x]][pt[:y]] = 1
	printMaze(maze)
end

if maze[end_pt[:x]][end_pt[:y]] == 0
    puts "�䤣��X�f"
end

printMaze(maze)
