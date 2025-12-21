public interface TokenLogService {
    TokenLog addLog(Long tokenId, String msg);
    List<TokenLog> getLogs(Long tokenId);
}
