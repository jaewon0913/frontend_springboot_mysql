<template>
    <div class="title">
        <p class="title__task">
            You've got
            <span class="title__task-total">{{ taskTotal }}</span> tasks today.
        </p>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                taskTotal: 5
            };
        }
    };
</script>