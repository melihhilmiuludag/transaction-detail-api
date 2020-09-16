package tr.mhu.core.domain.dtos;

import lombok.Data;

/**
 * @author muludag on 13.09.2020
 */
@Data
public class AgentResponseDto {
	Integer id;
	String customerIp;
	String customerUserAgent;
	String merchantIp;
	String merchantUserAgent;
	String created_at;
	String updated_at;
	String deleted_at;
}
