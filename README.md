# NestJS Monitoring Utils - Healthcheck & Logger

Esta biblioteca foi desenvolvida para fornecer componentes reutilizáveis para microsserviços em NestJS, focando em dois aspectos essenciais: **Healthcheck** (verificação de saúde dos serviços) e **Logger** (sistema de log). A biblioteca é modular, permitindo a fácil integração desses componentes em diferentes microsserviços, promovendo consistência e eficiência no desenvolvimento.

## Índice

- [Instalação](#instalação)
- [Configuração](#configuração)
  - [Healthcheck](#healthcheck)
  - [Logger](#logger)
- [Boas Práticas](#boas-práticas)
- [Testes](#testes)
- [Versionamento](#versionamento)
- [Contribuição](#contribuição)

## Instalação

Para instalar a biblioteca, rode o seguinte comando:

```bash
npm install nestjs-microservices-lib
```

## Configuração

### Healthcheck

O módulo **Healthcheck** fornece um endpoint para monitorar a saúde dos serviços utilizados no sistema.

#### Configuração do Módulo

1. Importe o `HealthcheckModule` no seu módulo principal do microsserviço:

```typescript
import { Module } from '@nestjs/common';
import { HealthcheckModule } from 'nestjs-microservices-lib';

@Module({
  imports: [HealthcheckModule],
})
export class AppModule {}
```

2. Implemente o controller para expor o endpoint `/health`:

```typescript
import { Controller, Get, HttpCode } from '@nestjs/common';
import { ApiOperation, ApiResponse, ApiTags } from '@nestjs/swagger';
import { HealthcheckService } from '../services/healthcheck.service';

@ApiTags('healthcheck')
@Controller('healthcheck')
export class HealthcheckController {
  constructor(private readonly healthcheckService: HealthcheckService) {}

  @Get()
  @HttpCode(200)
  @ApiOperation({ summary: 'Get status if Server is OK' })
  @ApiResponse({ status: 200, description: 'ok' })
  @ApiResponse({ status: 500, description: 'Internal server error' })
  async status(): Promise<any> {
    const status = await this.healthcheckService.status();
    return {
      status: status,
      timestamp: new Date().toISOString(),
    };
  }
}
```

#### Configuração do Serviço

O serviço `HealthcheckService` é responsável por recuperar as informações de configuração e status dos serviços:

```typescript
import { Injectable } from '@nestjs/common';
import { ConfigService } from '@nestjs/config';

@Injectable()
export class HealthcheckService {
  constructor(private configService: ConfigService) {}

  status(): any {
    return {
      appName: this.configService.get('app.name'),
      appVersion: this.configService.get('app.version'),
    };
  }
}
```

#### Exemplo de Resposta

A resposta do endpoint `/healthcheck` pode ser:

```json
{
  "status": "ok",
  "appName": "my-service",
  "appVersion": "1.0.0",
  "timestamp": "2024-10-10T14:00:00Z"
}
```

- **200 OK**: O serviço está em execução normal.
- **503 Service Unavailable**: O serviço está indisponível.

### Logger

O módulo **Logger** padroniza e facilita a geração de logs, permitindo integração com ferramentas como ELK Stack, Datadog, entre outras.

#### Configuração do Módulo

1. Importe o `LoggerModule` no seu microsserviço:

```typescript
import { Module } from '@nestjs/common';
import { LoggerModule } from 'nestjs-microservices-lib';

@Module({
  imports: [LoggerModule],
})
export class AppModule {}
```

2. Utilize o `LoggerService` para registrar logs no seu serviço ou controladores:

```typescript
import { LoggerService } from 'nestjs-microservices-lib';

@Injectable()
export class ExampleService {
  constructor(private readonly logger: LoggerService) {}

  someFunction() {
    this.logger.info('This is an info log message.');
  }
}
```

#### Níveis de Log

O Logger suporta os seguintes níveis de log:

- `INFO`: Para informações gerais.
- `WARN`: Para alertas.
- `ERROR`: Para erros.
- `DEBUG`: Para informações de depuração.
- `VERBOSE`: Para mensagens detalhadas.

#### Exemplo de Log

```json
{
  "timestamp": "2024-10-10T14:00:00Z",
  "level": "INFO",
  "message": "This is an info log message",
  "context": "ExampleService",
  "correlationId": "abc123"
}
```

## Boas Práticas

- Adicione verificações de saúde facilmente configuráveis no Healthcheck para garantir que os serviços estão funcionando corretamente.
- Use o Logger para manter a consistência dos logs em diferentes microsserviços e facilitar o monitoramento e depuração.
- Utilize os níveis de log apropriados (`INFO`, `WARN`, `ERROR`, etc.) para diferenciar a criticidade dos eventos registrados.

## Testes

A biblioteca vem com testes unitários para garantir o comportamento correto dos módulos.

Para rodar os testes:

```bash
npm run test
```

## Versionamento

Este projeto segue o padrão de versionamento [SemVer](https://semver.org/).

- **Versão 1.0.0**: Onde `1` representa uma versão principal com mudanças que podem quebrar compatibilidade, `0` são novas funcionalidades que não quebram compatibilidade, e `0` para correções de bugs.

## Contribuição

Contribuições são bem-vindas! Por favor, envie um Pull Request ou abra uma Issue no repositório [GitHub](https://git.telefonicabigdata.com/vivo/desenvolvimento/amazonia/valesaudesempre/nestjs-monitoring-utils).

---


