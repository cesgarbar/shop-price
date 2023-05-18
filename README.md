## INDITEX RETAIL SHOP PRICE

### Introduction
This service is a service for manage price.

H2Console=http://localhost:10001/inditex/shop-price/h2-console

### Build and Test
🔨🔨🔨
This service needs the following environment variables:
```
INDITEX_SHOPPRICE_LOG_FILE=inditex-shop-price
INDITEX_SHOPPRICE_LOG_LEVEL=debug
INDITEX_SHOPPRICE_LOG_PATH=/data/inditex/logs/
INDITEX_SHOPPRICE_LOG_PATTERN_CONSOLE=[%d{yyyy-MM-dd HH:mm:ss,SSS}] -> %-5p [%c{0}][%M]:%L %m | [DT:%X{traceId:--},%X{spanId:--},%X{X-Span-Export:--}] | [E:%X{environment:--}][M:%X{machine:--}][U:%X{userId:--}][S:%X{sessionId:--}][R:%X{requestURL:--}][%r][%t] |%n
INDITEX_SHOPPRICE_LOG_PATTERN_FILE=%d{yyyy-MM-dd HH:mm:ss,SSS}] -> %-5p [%c{0}][%M]:%L %m | [DT:%X{traceId:--},%X{spanId:--},%X{X-Span-Export:--}] | [E:%X{environment:--}][M:%X{machine:--}][U:%X{userId:--}][S:%X{sessionId:--}][R:%X{requestURL:--}][%r][%t] |%n
```