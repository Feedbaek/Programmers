def solution(N, stages):
	cur_lev = [0] * N
	pass_lev = [0] * N
	fail = [0] * N
	stage_idx = [0] * N
	for idx in range(N):
		stage_idx[idx] = idx + 1
	for lev in stages:
		for idx in range(lev):
			if idx != N:
				pass_lev[idx] += 1
		if (lev - 1) != N:
			cur_lev[lev - 1] += 1
	for idx in range(N):
		if pass_lev[idx] == 0:
			fail[idx] = 0
		else:
			fail[idx] = cur_lev[idx] / pass_lev[idx]
	for idx in range(N - 1):
		for n in range(0, N - idx - 1):
			if fail[n] < fail[n + 1]:
				cnt = fail[n]
				fail[n] = fail[n + 1]
				fail[n + 1] = cnt
				cnt = stage_idx[n]
				stage_idx[n] = stage_idx[n + 1]
				stage_idx[n + 1] = cnt
	return stage_idx
