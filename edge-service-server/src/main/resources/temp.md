#엣지 서비스
- 마이크로서비스는 클라리언트에 서비스를 제공한다.
- HTML5, 안드로이드, IOS, 플레이스테이션, 엑스박스, 스마트TV 등 여러 클라이언트 종류가 있다.
- MAC 주소와 IP 주소를 가질 수 있는 어떤 것이든 클라이언트가 될 수 있다.
- 도로에 있는 센서, 체내 조직에 심어져 있는 사람 등의 모든 것이 클라이언트가 될 수 있다.

###클라이언트는 저마다 다른 유형의 데이터와 서비스를 필요로 한다.
- 메모리 용량이나 CPU 용량 제한이 있어 처리할 수 있는 컨텐츠 양이 제한된 클라이언트
- 특별한 컨텐트 타입이나 인코딩을 필요로 하는 클라이언트
- 계층(hierarchical) 데이터를 필요로 하는 클라이언트와 계층 없는 데이터를 필요로 하는 클라이언트
- 부동산 정보 화면처럼 데이터를 한 번에 모두 로딩하지 않고 조금씩 점진적으로 로딩해야 하는 클라이언트
- 스트리밍 방식이나 잘게 잘라 보내는 방식의 데이터에 적합한 클라이언트
- 사용자 액션에 의해 응답이 바뀔 수도 있는 클라이언트
- 메타 데이터 필드, 절달 방법, 상호작용 모델 등을 바꿀 수도 있는 클라이언트

```
이처럼 다양한 클라이언트에 각각 대응하는 수많은 마이크로서비스를 두게 되면 머지않아 통제할 수 없는 수준에 도달하게 될 것이다!   
   >> 이를 해결하기 위해 클라이언트와 백엔드 서버 사이에 엣지 서비스를 둔다.
```

```
@SpringBootApplication
@EnableEurekaServer
public class EdgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdgeServiceApplication.class, args);
    }
}
```