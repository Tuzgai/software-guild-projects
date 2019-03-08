def fib(n):
  if n == 0:
    return 0
  if n == 1:
    return 1
  return fib(n-2) + fib(n-1)


def isPrime(n):
  if n == 0 or n == 1:
    return False

  for i in range(2, int(n/2)):
    if n % i == 0:
      return False
  return True


n = 0
i = 0
s = 0
while n < 4000000:
  n = fib(i)
  if n % 2 == 0:
    s += n
  i += 1

if n % 2 == 0:
  s -= n

print(f'The sum of the even fibonacci numbers < 4 million is: {s}')

n = 0
i = 0
s = 0
while n < 4000000:
  n = fib(i)
  if isPrime(n):
    s += n
  i += 1

if isPrime(n):
  s -= n

print(f'The sum of the prime fibonacci numbers < 4 million is: {s}')
