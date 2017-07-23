# Charlie Green & Danielle Covarrubias

class Zillion:
	def __init__(self, digits):
		self.l = []
		for char in digits:
			if not (char == ' ' or char == ','):
				if not (char >= '0' and char <= '9'):
					raise RuntimeError
					
			if (char == ' ' or char == ',') and not (char >= '0' and char <= '9'):
				raise RuntimeError
				
		for char in digits:
			if not (char == ' ' or char == ','):
				self.l.append(int(char))
		
	def increment(self):
		i = len(self.l) - 1
		while i >= 0:
			if self.l[i] == 9: 
				self.l[i] = 0
			else:
				self.l[i] += 1
				break
			i-=1
		
		if self.isZero():
			self.l = [1] + self.l
		
		return self.l
		
		
	def isZero(self):
		for index in self.l:
			if index > 0: 
				return False
		return True 
				
	def toString(self):
		s = ''
		for char in self.l:
			s += str(char)
			
		return s
	
z = Zillion("999")	
print(z.isZero())	#False
print(z.increment())	#[1, 0, 0, 0]
print(z.toString())	#1000

z = Zillion("1001") 
print(z.isZero()) #False
print(z.increment()) #[1, 0, 0, 2]
print(z.toString()) #1002

z = Zillion("000")
print(z.isZero()) #True
print(z.increment()) #[0, 0, 1]
print(z.toString()) #001

z = Zillion("63474")
print(z.isZero()) #False
print(z.increment()) #[6, 3, 4, 7, 5]
print(z.toString()) #63475

z = Zillion("999 999 999 998")
print(z.isZero()) #False
print(z.increment()) #[9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9]
print(z.toString()) #999999999999

z = Zillion("999,999,999,998")
print(z.isZero()) #False
print(z.increment()) #[9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9]
print(z.toString()) #999999999999

z = Zillion(",,") #raise RuntimeError
print(z.isZero())
print(z.increment())
print(z.toString())
