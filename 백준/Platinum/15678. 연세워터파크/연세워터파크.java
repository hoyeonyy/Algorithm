import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int idx;
		long data;
		
		public Node (int idx, long data) {
			this.idx = idx;
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Node[] node = new Node[N];
			for (int i = 0; i < N; ++i) {
				long data = Long.parseLong(st.nextToken());
				node[i] = new Node(i, data);
			}

			Deque<Node> deq = new ArrayDeque<>();
			long ans = -(long)1e12;
			for (int i = 0; i < N; i++) {
				//구간 벗어나는 최댓값 제거
				while (!deq.isEmpty() && deq.peekLast().idx + D < i) {
					deq.pollLast();
				}
				
				if (deq.isEmpty()) {
					deq.offer(node[i]);
					continue;
				}
				
				//node[i].data가 0이상이라면 최댓값 갱신
				if (deq.peekLast().data <= deq.peekLast().data + node[i].data) {
					deq.addLast(new Node(i, deq.peekLast().data + node[i].data));
				} 
				//node[i].data가 음수라면 (현재 최댓값 + node[i].data)보다 작은 최댓값 제거 및 추가
				else {
					while (deq.size() > 1 && deq.peekFirst().data <= deq.peekLast().data + node[i].data) {
						deq.pollFirst();
					}
					deq.addFirst(new Node(i, deq.peekLast().data + node[i].data));
				}
				
				//node[i].data가 최댓값인 경우 최댓값 갱신
				if (deq.peekLast().data <= node[i].data) {
					deq.addLast(new Node(i, node[i].data));
				}
				ans = Math.max(ans, deq.peekLast().data);
			}
			bw.write(ans + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}