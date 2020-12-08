# Kafka Kubernetes Configuration

This service uses [`strimzi`](https://strimzi.io) to deploy `Kafka` in `Kubernetes` environment.

## Prerequisites

To start kafka in Kubernetes environment you have to install:

* `helm`

## How to start (with script)

TODO: Create script for starting kubernetes environment

## How to start (manually)

Described steps are only appliable to hosts running on `Unix`, `Windows` configuration should be simillar, but please refer to offical documentation for tools like [`helm`](https://helm.sh/docs/intro/install/), [`minikube`](https://minikube.sigs.k8s.io/docs/start/) and [`kubectl`](https://kubernetes.io/docs/tasks/tools/install-kubectl/). Handling of environment variables would also be probably different.

1. First start your kubernetes environment
2. Create `kafka` namespace

    ```bash
    kubectl create ns kafka
    ```

3. Add `strimzi` repository to `helm`:

    ```bash
    helm repo add strimzi https://strimzi.io/charts/
    ```

4. Install `strimzi`:

    ```bash
    helm install strimzi-kafka strimzi/strimzi-kafka-operator -n kafka
    ```

5. Then use `kubectl` to start `kafka`:

    ```bash
    kubectl apply -f ./kafka/kafka-setup.yml
    ```

6. You have to wait a few minutes and then execute:

    ```bash
    kubectl apply -f ./kafka/kafka-event-topic.yml
    ```

7. Save `minikube` ip address to environment variable:

    ```bash
    export MINIKUBE_IP=(minikube ip)
    ```

## Configuration

TODO: Write configuration description

## Debugging

Debugging can be simplified by directly connecting to kafka `producer` and `consumer`

### Connecting to `producer`

In order to connect to `producer` on topic `event-topic` you can execute following command:

```bash
kubectl run kafka-producer -n kafka -ti --image=quay.io/strimzi/kafka:latest-kafka-2.6.0 --rm=true --restart=Never -- bin/kafka-console-producer.sh --broker-list new-education-kafka-bootstrap:9092 --topic event-topic
```

### Connecting to `consumer`

Similarly, in order to connect to kafka `consumer` on topic `event-topic` you can execute:

```bash
kubectl run kafka-consumer -n kafka -ti --image=quay.io/strimzi/kafka:latest-kafka-2.6.0 --rm=true --restart=Never -- bin/kafka-console-consumer.sh --bootstrap-server new-education-kafka-bootstrap:9092 --topic event-topic --from-beginning
```

### Displaying metadata

You can display metadata easily (and much more) with `kafkacat`. To check metadata for all topics execute:

```bash
kafkacat -C -b $MINIKUBE_IP:32006 -L
```

For specific topic:

```bash
kafkacat -C -b $MINIKUBE_IP:32006 -L -t <topic-name>
```

For example:

```bash
kafkacat -C -b $MINIKUBE_IP:32006 -L -t event-topic
```

### Connecting with consumer with `kafkacat`

`kafkacat` can also be used to display topic contents. To do this you have to execute:

```bash
kafkacat -C -b $MINIKUBE_IP:32006 -t <topic-name>
```

For example:

```bash
kafkacat -C -b $MINIKUBE_IP:32006 -t event-topic
```
